package com.wordpress.ilyaps.services.accountService.message;

import com.wordpress.ilyaps.services.accountService.AccountService;
import com.wordpress.ilyaps.services.accountService.dataset.UserProfile;
import com.wordpress.ilyaps.services.servletsService.message.MsgSrvLeft;
import com.wordpress.ilyaps.messageSystem.Address;
import com.wordpress.ilyaps.messageSystem.Message;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ilya on 13.12.15.
 */
public class MsgAccLeaving extends MsgToAccountService {
    @NotNull
    private final String sessionId;
    @NotNull
    private final String email;

    public MsgAccLeaving(
            @NotNull Address from,
            @NotNull Address to,
            @NotNull String sessionId,
            @NotNull String email
    ) {
        super(from, to);
        this.sessionId = sessionId;
        this.email = email;
    }

    @Override
    protected void exec(@NotNull AccountService service) {
        final UserProfile profile = service.leaving(sessionId);
        final Message msg = new MsgSrvLeft(getTo(), getFrom(), email, sessionId, profile);
        service.sendMessage(msg);
    }
}
