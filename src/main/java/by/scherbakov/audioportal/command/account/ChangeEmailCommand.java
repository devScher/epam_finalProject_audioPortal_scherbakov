package by.scherbakov.audioportal.command.account;

import by.scherbakov.audioportal.command.ActionCommand;
import by.scherbakov.audioportal.entity.User;
import by.scherbakov.audioportal.logic.UserLogic;
import by.scherbakov.audioportal.manager.ConfigurationManager;
import by.scherbakov.audioportal.manager.MessageManager;
import by.scherbakov.audioportal.servlet.SessionRequestContent;

public class ChangeEmailCommand implements ActionCommand {
    private static final String EMAIL_PARAMETER = "email";
    private static final String USER_ATTRIBUTE = "user";
    private static final String LOCALE_ATTRIBUTE = "locale";
    private static final String MISTAKE_ATTRIBUTE = "changeEmailError";
    private static final String ACCOUNT_PAGE = "path.page.account";

    @Override
    public String execute(SessionRequestContent requestContent) {
        String page = null;
        String email = requestContent.getReguestParameterValue(EMAIL_PARAMETER);
        User user = (User) requestContent.getSessionAttributeValue(USER_ATTRIBUTE);
        UserLogic userLogic = new UserLogic();
        String message = userLogic.changeEmail(user.getLogin(),email);
        if (!message.isEmpty()) {
            String errorMessage = MessageManager.getMessage(message,
                    (String) requestContent.getSessionAttributeValue(LOCALE_ATTRIBUTE));
            requestContent.setRequestAttributeValue(MISTAKE_ATTRIBUTE, errorMessage);
        }else {
            user.setEmail(email);
            requestContent.setSessionAttributeValue(USER_ATTRIBUTE,user);
        }
        page = ConfigurationManager.getProperty(ACCOUNT_PAGE);
        return page;
    }
}
