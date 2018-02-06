package by.scherbakov.audioportal.command.account;

import by.scherbakov.audioportal.command.ActionCommand;
import by.scherbakov.audioportal.entity.User;
import by.scherbakov.audioportal.logic.UserLogic;
import by.scherbakov.audioportal.manager.ConfigurationManager;
import by.scherbakov.audioportal.manager.MessageManager;
import by.scherbakov.audioportal.servlet.SessionRequestContent;
import org.apache.commons.codec.digest.DigestUtils;

public class ChangePasswordCommand implements ActionCommand {
    private static final String PASSWORD_PARAMETER = "password";
    private static final String USER_ATTRIBUTE = "user";
    private static final String LOCALE_ATTRIBUTE = "locale";
    private static final String MISTAKE_ATTRIBUTE = "changePasswordError";
    private static final String ACCOUNT_PAGE = "path.page.account";

    @Override
    public String execute(SessionRequestContent requestContent) {
        String page = null;
        String password = requestContent.getReguestParameterValue(PASSWORD_PARAMETER);
        User user = (User) requestContent.getSessionAttributeValue(USER_ATTRIBUTE);
        UserLogic userLogic = new UserLogic();
        String message = userLogic.changePassword(user.getLogin(),password);
        if (!message.isEmpty()) {
            String errorMessage = MessageManager.getMessage(message,
                    (String) requestContent.getSessionAttributeValue(LOCALE_ATTRIBUTE));
            requestContent.setRequestAttributeValue(MISTAKE_ATTRIBUTE, errorMessage);
        }else {
            user.setPassword(DigestUtils.md5Hex(password));
            requestContent.setSessionAttributeValue(USER_ATTRIBUTE,user);
        }
        page = ConfigurationManager.getProperty(ACCOUNT_PAGE);
        return page;
    }
}
