package by.scherbakov.audioportal.command.admin;

import by.scherbakov.audioportal.command.ActionCommand;
import by.scherbakov.audioportal.dao.AlbumDAO;
import by.scherbakov.audioportal.entity.Album;
import by.scherbakov.audioportal.entity.AudioTrack;
import by.scherbakov.audioportal.logic.AlbumLogic;
import by.scherbakov.audioportal.logic.AudioTrackLogic;
import by.scherbakov.audioportal.manager.MessageManager;
import by.scherbakov.audioportal.servlet.SessionRequestContent;

public class ChangeAlbumCommand implements ActionCommand {
    private static final String TRACK_ATTRIBUTE = "track";
    private static final String ALBUM_PARAMETER = "album";
    private static final String STUDIO_PARAMETER = "studio";
    private static final String DATE_PARAMETER = "date";
    private static final String LOCALE_ATTRIBUTE = "locale";
    private static final String MISTAKE_ATTRIBUTE = "updateAudioTrackError";
    private static final String TRACK_PAGE_ACTION = "/web?command=track_info&track=";

    @Override
    public String execute(SessionRequestContent requestContent) {
        String page = null;
        AudioTrack track = (AudioTrack) requestContent.getSessionAttributeValue(TRACK_ATTRIBUTE);
        String albumName = requestContent.getReguestParameterValue(ALBUM_PARAMETER);
        String studio = requestContent.getReguestParameterValue(STUDIO_PARAMETER);
        String date = requestContent.getReguestParameterValue(DATE_PARAMETER);
        AlbumLogic albumLogic = new AlbumLogic();
        Album album = albumLogic.updateAlbum(albumName,studio,date);
        track.setIdAlbum(album.getId());
        AudioTrackLogic audioTrackLogic = new AudioTrackLogic();
        String message = audioTrackLogic.updateAudioTrack(track);
        if (!message.isEmpty()) {
            String errorMessage = MessageManager.getMessage(message,
                    (String) requestContent.getSessionAttributeValue(LOCALE_ATTRIBUTE));
            requestContent.setRequestAttributeValue(MISTAKE_ATTRIBUTE, errorMessage);
        }
        page = TRACK_PAGE_ACTION+track.getId();
        return page;
    }
}
