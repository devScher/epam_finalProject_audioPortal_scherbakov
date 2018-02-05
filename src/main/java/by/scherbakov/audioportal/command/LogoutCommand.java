package by.scherbakov.audioportal.command;

import by.scherbakov.audioportal.command.ActionCommand;
import by.scherbakov.audioportal.manager.ConfigurationManager;
import by.scherbakov.audioportal.servlet.SessionRequestContent;

public class LogoutCommand implements ActionCommand {
    private static final String USER_ATTRIBUTE = "user";
    private static final String SIGN_IN_ATTRIBUTE = "isSignIn";
    private static final String TRACK_ATTRIBUTE = "tracks";
    private static final String ROLE_ATTRIBUTE = "role";
    private static final String LOGIN_PAGE = "path.page.login";

    @Override
    public String execute(SessionRequestContent requestContent) {
        String page = null;
        requestContent.setSessionAttributeValue(USER_ATTRIBUTE,null);
        requestContent.setSessionAttributeValue(SIGN_IN_ATTRIBUTE, null);
        requestContent.setSessionAttributeValue(TRACK_ATTRIBUTE, null);
        requestContent.setSessionAttributeValue(USER_ATTRIBUTE, null);
        requestContent.setSessionAttributeValue(ROLE_ATTRIBUTE, null);
        page= ConfigurationManager.getProperty(LOGIN_PAGE);
        return page;
    }
}