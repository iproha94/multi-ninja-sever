package com.wordpress.ilyaps.services.gamemechService.message;

import com.wordpress.ilyaps.services.gamemechService.GamemechService;
import com.wordpress.ilyaps.messageSystem.Abonent;
import com.wordpress.ilyaps.messageSystem.Address;
import com.wordpress.ilyaps.messageSystem.Message;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ilya on 13.12.15.
 */
public abstract class MsgToGamemechService extends Message{
    public MsgToGamemechService(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec(Abonent abonent) {
        if (abonent instanceof GamemechService) {
            exec((GamemechService) abonent);
        }
    }

    protected abstract void exec(@NotNull GamemechService service);
}
