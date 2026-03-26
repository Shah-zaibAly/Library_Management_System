package com.nust.lms.model;
/**
 * Interface demonstrates ABSTRACTION.
 * It defines behavior ("what" should happen) without implementation details ("how").
 * Any class that can be issued/returned can implement this contract.
 */
public interface Borrowable {
    boolean issueTo(com.nust.lms.model.Member member);
    boolean returnFrom(com.nust.lms.model.Member member);
}
