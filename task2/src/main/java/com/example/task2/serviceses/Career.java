package com.example.task2.serviceses;

import com.example.task2.model.Cargo;
import com.example.task2.util.BucketLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Career implements Terminal{
    @Autowired
    private BucketLoader bucketLoader;
    @Override
    public void upload(Cargo cargo) {
           cargo.setFully(true);
           bucketLoader.work();
        System.out.println("Насыпали до грузоподъемности");
    }

    @Override
    public void unloading(Cargo cargo) {
           cargo.setFully(false);
        System.out.println("Открыть люки, не забудь почистить от остатков груза");
    }

    @Override
    public String myType() {
        return "сыпучие";
    }
}
