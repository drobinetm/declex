/**
 * Copyright (C) 2016-2017 DSpot Sp. z o.o
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dspot.declex.test.model.servermodel;

import static com.dspot.declex.Action.*;

import com.dspot.declex.annotation.Event;
import com.dspot.declex.annotation.Model;

import com.dspot.declex.annotation.Populate;
import com.dspot.declex.test.model.servermodel.model.ServerModelEntity;
import com.dspot.declex.test.model.servermodel.model.ServerModelEntity_;
import com.dspot.declex.test.util.CalcHelper;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class ServerModelBean {

    int post_id = 1;

    @Bean
    ServerModelEntity serverModelEntity;

    /**
     *  List Posts
     * **/
    @Model(async = true, lazy = true)
    List<ServerModelEntity> listPosts;

    @Model(async = true, lazy = true)
    List<ServerModelBean_> enhancedListPosts;

    /**
     *  Read Posts
     * **/
    @Model(async = true,  orderBy = "read", lazy = true, query = "{post_id}")
    List<ServerModelEntity> readPost;

    @Model(async = true,  orderBy = "read", lazy = true, query = "{post_id}")
    List<ServerModelBean_> enhancedReadPost;

    /**
     *  Posts
     * **/
    @Model(async = true, orderBy = "create", lazy = true)
    ServerModelEntity_ post;

    public void downloadListPosts(Runnable done, Runnable failed) {
        $LoadModel(listPosts);

        if($LoadModel.Done) {
            if(done != null) done.run();
        }

        if($LoadModel.Failed) {
            if(failed != null) failed.run();
        }
    }

    /**
     *  Test the class generated by the declex
     * **/
    public void downloadEnhancedListPosts(Runnable done, Runnable failed) {
        $LoadModel(enhancedListPosts);

        if($LoadModel.Done) {
            if(done != null) done.run();
        }

        if($LoadModel.Failed) {
            if(failed != null) failed.run();
        }
    }

    public  void downloadReadPosts(Runnable done, Runnable failed) {
        $LoadModel(readPost);

        if($LoadModel.Done) {
            if(done != null) done.run();
        }

        if($LoadModel.Failed) {
            if(failed != null) failed.run();
        }
    }

    /**
     *  Test the class generated by the declex
     * **/
    public void downloadEnhancedReadPost(Runnable done, Runnable failed) {
        $LoadModel(enhancedReadPost).query("{post_id}");

        if($LoadModel.Done) {
            if(done != null) done.run();
        }

        if($LoadModel.Failed) {
            if(failed != null) failed.run();
        }
    }

    public void createPost(Runnable done, Runnable failed) {
        $PutModel(post);

        if($PutModel.Done) {
            if(done != null) done.run();
        }

        if($PutModel.Failed) {
            if(failed != null) failed.run();
        }
    }

    public  void updatePost(boolean fields, Runnable done, Runnable failed) {
        if(fields) {
            post.setUserId(1);
            post.setBody("Hello Body!!!");
            post.setTitle("Hello Title!!!");
        }

        $PutModel(post).orderBy("update").query("{post_id}");

        if($PutModel.Done) {
            if(done != null) done.run();
        }

        if($PutModel.Failed) {
            if(failed != null) failed.run();
        }
    }
}
