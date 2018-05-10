package org.blockchain.identity.blockchain.agent;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    int sender;
    int receiver;
    MESSAGE_TYPE type;
    List<Block> blocks;
    String data;
    boolean isValidData;

    public enum MESSAGE_TYPE {
        READY, INFO_NEW_BLOCK, REQ_ALL_BLOCKS, RSP_ALL_BLOCKS, REQ_CHECK_DATA, RSP_CHECK_DATA
    }

    @Override
    public String toString() {
        return String.format("Message {type=%s, sender=%d, receiver=%d, blocks=%s, idValidData=%s}", type, sender,
                receiver, blocks, isValidData);
    }

    static class MessageBuilder {
        private final Message message = new Message();

        MessageBuilder withSender(final int sender) {
            message.sender = sender;
            return this;
        }

        MessageBuilder withReceiver(final int receiver) {
            message.receiver = receiver;
            return this;
        }

        MessageBuilder withType(final MESSAGE_TYPE type) {
            message.type = type;
            return this;
        }

        MessageBuilder withBlocks(final List<Block> blocks) {
            message.blocks = blocks;
            return this;
        }

        MessageBuilder withIsValidData(final boolean isValidData) {
            message.isValidData = isValidData;
            return this;
        }

        MessageBuilder withData(final String data) {
            message.data = data;
            return this;
        }

        Message build() {
            return message;
        }

    }
}
