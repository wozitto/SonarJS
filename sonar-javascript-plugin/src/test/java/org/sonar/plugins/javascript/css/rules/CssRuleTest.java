/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2021 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.javascript.css.rules;

import com.google.gson.Gson;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import org.sonar.plugins.javascript.css.CssRules;

import static org.assertj.core.api.Assertions.assertThat;

class CssRuleTest {

  @Test
  void class_name_should_match_stylelint_key() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    for (Class ruleClass : CssRules.getRuleClasses()) {
      CssRule rule = (CssRule)ruleClass.getConstructor().newInstance();
      String stylelintRuleKeyWithoutUnderscore = rule.stylelintKey().replace("-", "");
      assertThat(ruleClass.getSimpleName()).isEqualToIgnoringCase(stylelintRuleKeyWithoutUnderscore);
    }
  }

  @Test
  void rules_default_is_empty() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Set<Class> rulesWithStylelintOptions = Sets.newSet(
      AtRuleNoUnknown.class,
      DeclarationBlockNoDuplicateProperties.class,
      PropertyNoUnknown.class,
      SelectorPseudoClassNoUnknown.class,
      SelectorPseudoElementNoUnknown.class,
      SelectorTypeNoUnknown.class,
      UnitNoUnknown.class);

    for (Class ruleClass : CssRules.getRuleClasses()) {
      CssRule rule = (CssRule)ruleClass.getConstructor().newInstance();
      if (rulesWithStylelintOptions.contains(rule.getClass())) {
        assertThat(rule.stylelintOptions()).isNotEmpty();
      } else {
        assertThat(rule.stylelintOptions()).isEmpty();
      }
    }
  }

  @Test
  void selector_pseudo_class_options() {
    SelectorPseudoClassNoUnknown selectorPseudoClassNoUnknown = new SelectorPseudoClassNoUnknown();
    String optionsAsJson = new Gson().toJson(selectorPseudoClassNoUnknown.stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignorePseudoClasses\":[\"local\",\"global\",\"export\",\"import\"]}]");
    selectorPseudoClassNoUnknown.ignoredPseudoClasses = "foo,/^bar/";
    optionsAsJson = new Gson().toJson(selectorPseudoClassNoUnknown.stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignorePseudoClasses\":[\"foo\",\"/^bar/\"]}]");
  }

  @Test
  void property_no_unknown_options() {
    String optionsAsJson = new Gson().toJson(new PropertyNoUnknown().stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignoreProperties\":[\"composes\",\"/^mso-/\"],\"ignoreSelectors\":[\"/^:export.*/\",\"/^:import.*/\"]}]");
  }

  @Test
  void selector_type_no_unknown_default() {
    String optionsAsJson = new Gson().toJson(new SelectorTypeNoUnknown().stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignoreTypes\":[\"/^(mat|md|fa)-/\"],\"ignore\":[\"custom-elements\"]}]");
  }

  @Test
  void selector_type_no_unknown_custom() {
    SelectorTypeNoUnknown selectorTypeNoUnknown = new SelectorTypeNoUnknown();
    selectorTypeNoUnknown.ignoreTypes = "/^(mat|md|fa)-/";
    selectorTypeNoUnknown.ignore = "custom-elements, default-namespace";
    String optionsAsJson = new Gson().toJson(selectorTypeNoUnknown.stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignoreTypes\":[\"/^(mat|md|fa)-/\"],\"ignore\":[\"custom-elements\",\"default-namespace\"]}]");
  }

  @Test
  void selector_pseudo_element_no_unknown_default() {
    String optionsAsJson = new Gson().toJson(new SelectorPseudoElementNoUnknown().stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignorePseudoElements\":[\"ng-deep\",\"v-deep\"]}]");
  }

  @Test
  void selector_pseudo_element_no_unknown_custom() {
    SelectorPseudoElementNoUnknown selectorPseudoElementNoUnknown = new SelectorPseudoElementNoUnknown();
    selectorPseudoElementNoUnknown.ignorePseudoElements =  "ng-deep, /^custom-/";
    String optionsAsJson = new Gson().toJson(selectorPseudoElementNoUnknown.stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignorePseudoElements\":[\"ng-deep\",\"/^custom-/\"]}]");
  }

  @Test
  void units_no_unknown_options() {
    String optionsAsJson = new Gson().toJson(new UnitNoUnknown().stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignoreUnits\":[\"x\"]}]");
  }

  @Test
  void at_rule_unknown_default() {
    String optionsAsJson = new Gson().toJson(new AtRuleNoUnknown().stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignoreAtRules\":[\"value\",\"at-root\",\"content\",\"debug\",\"each\",\"else\",\"error\",\"for\",\"function\",\"if\",\"include\",\"mixin\",\"return\",\"warn\",\"while\",\"extend\",\"use\",\"/^@.*/\"]}]");
  }

  @Test
  void at_rule_unknown_custom() {
    AtRuleNoUnknown instance = new AtRuleNoUnknown();
    instance.ignoredAtRules = "foo, bar";
    String optionsAsJson = new Gson().toJson(instance.stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignoreAtRules\":[\"foo\",\"bar\"]}]");
  }

  @Test
  void declaration_block_no_duplicate_properties_default() {
    String optionsAsJson = new Gson().toJson(new DeclarationBlockNoDuplicateProperties().stylelintOptions());
    assertThat(optionsAsJson).isEqualTo("[true,{\"ignore\":[\"consecutive-duplicates-with-different-values\"]}]");
  }

  @Test
  void declaration_block_no_duplicate_properties_custom() {
    DeclarationBlockNoDuplicateProperties instance = new DeclarationBlockNoDuplicateProperties();
    instance.ignoreFallbacks = false;
    assertThat(instance.stylelintOptions()).isEmpty();
  }
}