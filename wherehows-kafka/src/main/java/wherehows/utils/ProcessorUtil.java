/**
 * Copyright 2015 LinkedIn Corp. All rights reserved.
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
 */
package wherehows.utils;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;


public class ProcessorUtil {

  private ProcessorUtil() {
  }

  /**
   * Find the diff from existing list to the updated list, with exclusion patterns.
   * @param existing List<String>
   * @param updated List<String>
   * @param exclusions List<Pattern>
   * @return List<String>
   */
  public static List<String> listDiffWithExclusion(@Nonnull List<String> existing, @Nonnull List<String> updated,
      @Nonnull List<Pattern> exclusions) {
    existing.removeAll(updated);

    return existing.stream()
        .filter(s -> exclusions.stream().noneMatch(p -> p.matcher(s).find()))
        .collect(Collectors.toList());
  }
}
