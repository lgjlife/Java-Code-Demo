package com.mq.kafka.serialize;


import com.caucho.hessian.io.HessianInput;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.util.Map;

@Slf4j
public class HessianDeSerialize<T> implements Deserializer<T> {
    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public T deserialize(String s, byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException();
        } else {
            try {

                log.info("bytes.length = " + bytes.length);
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                HessianInput hi = new HessianInput(bis);
                T result = (T)hi.readObject();
                return result;
                //  return null;
            } catch (Exception var5) {
                throw new RuntimeException();
            }
        }
    }



    @Override
    public void close() {

    }
}
