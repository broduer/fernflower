// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.java.decompiler.main.extern;

import org.jetbrains.java.decompiler.code.CodeConstants;
import org.jetbrains.java.decompiler.modules.decompiler.vars.VarVersionPair;

import java.util.Map;

public interface IVariableNameProvider {
  public Map<VarVersionPair,String> rename(Map<VarVersionPair,String> variables);

  default String renameAbstractParameter(String name, int index) {
     return name;
  }

  default String renameParameter(int flags, String type, String name, int index) {
     if ((flags & (CodeConstants.ACC_ABSTRACT | CodeConstants.ACC_NATIVE)) != 0)
        return renameAbstractParameter(name, index);
     return name;
  }

  public void addParentContext(IVariableNameProvider renamer);
}