
package com.link.spring.scope;

import com.link.spring.scope.service.MessageService;

/**
 * Message Printer.

 */
public class MessagePrinter {

    final private MessageService service;

    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}