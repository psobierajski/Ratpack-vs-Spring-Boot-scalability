
package controller;

import io.BlockingOperationSimulator;
import ratpack.exec.Blocking;
import ratpack.handling.Context;
import ratpack.server.RatpackServer;

public class RatpackApp {

    private final BlockingOperationSimulator simulator = new BlockingOperationSimulator();

    public static void main(String[] args) throws Exception {
        new RatpackApp().startServer();
    }

    private void startServer() throws Exception {
        RatpackServer.start(s -> s
                .handlers(h ->
                        h.get("blockFor/:milliseconds", this::block)
                )
        );
    }

    private void block(Context ctx) {
        int milliseconds = ctx.getPathTokens().asInt("milliseconds");
        Blocking.get(() -> simulator.blockFor(milliseconds))
                .map(String::valueOf)
                .then(ctx::render);
    }

}
