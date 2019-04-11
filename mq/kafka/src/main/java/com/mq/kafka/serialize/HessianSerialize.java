package com.mq.kafka.serialize;

import com.caucho.hessian.io.HessianOutput;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class HessianSerialize<T> implements Serializer<T>{

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, T t) {

        if (t == null) {
            throw new NullPointerException();
        } else {
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                HessianOutput ho = new HessianOutput(bos);
                ho.writeObject(t);

                byte[] result = bos.toByteArray();
                return result;
            } catch (Exception var4) {
                throw new RuntimeException();
            }
        }
    }





    @Override
    public void close() {

    }
}
