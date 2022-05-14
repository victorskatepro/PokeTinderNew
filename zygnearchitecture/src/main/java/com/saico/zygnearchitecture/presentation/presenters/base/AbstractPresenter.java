/**
 * Copyright (C) 2017 Bardur Thomsen Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saico.zygnearchitecture.presentation.presenters.base;


import com.saico.zygnearchitecture.domain.executor.base.Executor;
import com.saico.zygnearchitecture.domain.executor.base.MainThread;

/**
 * Base class all presenters
 *
 * All presenters should extend this class, and pass the member
 * parameters to the interactors which should run.
 */
public abstract class AbstractPresenter {

    protected final Executor executor;
    protected final MainThread mainThread;
    protected boolean activated;

    public AbstractPresenter(Executor executor, MainThread mainThread){
        this.executor = executor;
        this.mainThread = mainThread;
    }

    public boolean isActive(){
        return activated;
    }
}
