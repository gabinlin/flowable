package top.gabin.flowable.flowable.listener;

import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;

public interface CustomEventListener extends FlowableEventListener {
    FlowableEngineEventType getType();
}
