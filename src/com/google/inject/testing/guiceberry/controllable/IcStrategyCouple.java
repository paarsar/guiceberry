/*
 * Copyright (C) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.inject.testing.guiceberry.controllable;

import java.lang.reflect.Type;


import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.util.Types;

/**
 * One such class per injection controlling "strategy"
 * 
 * @author Luiz-Otavio Zorzella
 */
public class IcStrategyCouple {
  
  public interface IcServerStrategy {
    <T> T getOverride(ControllableId<T> pair, Provider<? extends T> delegate);
  }
  
  public interface IcClientStrategy {
    <T> void setOverride(ControllableId<T> pair, T override);
  }
  
  private final Class<? extends IcClientStrategy> clientControllerSupport;
  private final Class<? extends IcServerStrategy> serverControllerSupport;

  public IcStrategyCouple(
      Class<? extends IcClientStrategy> clientControllerSupport,
      Class<? extends IcServerStrategy> serverControllerSupport
      ) {
    this.clientControllerSupport = clientControllerSupport;
    this.serverControllerSupport = serverControllerSupport;
  }
  
  public Class<? extends IcClientStrategy> clientControllerClass() {
    return clientControllerSupport;
  }
  public Class<? extends IcServerStrategy> serverControllerClass() {
    return serverControllerSupport;
  }

  public static Key<?> wrap(Type raw, Key<?> annotationHolder) {
    Type type = Types.newParameterizedType(raw, annotationHolder.getTypeLiteral().getType());
    if (annotationHolder.getAnnotation() != null) {
      return Key.get(type, annotationHolder.getAnnotation());
    } else if (annotationHolder.getAnnotationType() != null) {
      return Key.get(type, annotationHolder.getAnnotationType());
    } else {
      return Key.get(type);
    }
  }
}