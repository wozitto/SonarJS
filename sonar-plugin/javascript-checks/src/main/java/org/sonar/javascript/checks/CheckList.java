/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2023 SonarSource SA
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
package org.sonar.javascript.checks;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.sonar.plugins.javascript.api.JavaScriptCheck;
import org.sonar.plugins.javascript.api.JavaScriptRule;
import org.sonar.plugins.javascript.api.TypeScriptRule;

public final class CheckList {

  public static final String JS_REPOSITORY_KEY = "javascript";
  public static final String TS_REPOSITORY_KEY = "typescript";

  public static final String REPOSITORY_NAME = "SonarAnalyzer";

  private CheckList() {}

  public static List<Class<? extends JavaScriptCheck>> getTypeScriptChecks() {
    return filterChecksByAnnotation(TypeScriptRule.class);
  }

  public static List<Class<? extends JavaScriptCheck>> getJavaScriptChecks() {
    return filterChecksByAnnotation(JavaScriptRule.class);
  }

  private static List<Class<? extends JavaScriptCheck>> filterChecksByAnnotation(
    Class<? extends Annotation> annotation
  ) {
    List<Class<? extends JavaScriptCheck>> allChecks = getAllChecks();
    return allChecks
      .stream()
      .filter(c -> c.isAnnotationPresent(annotation))
      .collect(Collectors.toList());
  }

  public static List<Class<? extends JavaScriptCheck>> getAllChecks() {
    return Arrays.asList(
      AdjacentOverloadSignaturesCheck.class,
      AlertUseCheck.class,
      AlphabeticalSortCheck.class,
      AlwaysUseCurlyBracesCheck.class,
      AnchorPrecedenceCheck.class,
      AngleBracketTypeAssertionCheck.class,
      ArgumentTypesCheck.class,
      ArgumentsCallerCalleeUsageCheck.class,
      ArgumentsUsageCheck.class,
      ArithmeticOperationReturningNanCheck.class,
      ArrayCallbackWithoutReturnCheck.class,
      ArrayConstructorsCheck.class,
      ArrowFunctionConventionCheck.class,
      AssertionsInTestsCheck.class,
      AssociativeArraysCheck.class,
      AwsApigatewayPublicApiCheck.class,
      AwsEc2RdsDmsPublicCheck.class,
      AwsEc2UnencryptedEbsVolumeCheck.class,
      AwsEfsUnencryptedCheck.class,
      AwsIamAllPrivilegesCheck.class,
      AwsIamAllResourcesAccessibleCheck.class,
      AwsIamPrivilegeEscalationCheck.class,
      AwsIamPublicAccessCheck.class,
      AwsOpenSearchServiceDomainCheck.class,
      AwsRdsUnencryptedDatabasesCheck.class,
      AwsRestrictedIpAdminAccessCheck.class,
      AwsS3BucketGrantedAccessCheck.class,
      AwsS3BucketInsecureHttpCheck.class,
      AwsS3BucketPublicAccessCheck.class,
      AwsS3BucketServerEncryptionCheck.class,
      AwsS3BucketVersioningCheck.class,
      AwsSagemakerUnencryptedNotebookCheck.class,
      AwsSnsUnencryptedTopicsCheck.class,
      AwsSqsUnencryptedQueueCheck.class,
      BitwiseOperatorsCheck.class,
      BoolParamDefaultCheck.class,
      BooleanEqualityComparisonCheck.class,
      BuiltInObjectOverriddenCheck.class,
      CertificateTransparencyCheck.class,
      ChaiDeterminateAssertionCheck.class,
      ClassNameCheck.class,
      ClassPrototypeCheck.class,
      CognitiveComplexityFunctionCheck.class,
      CollapsibleIfStatementsCheck.class,
      CollectionSizeComparisonCheck.class,
      CommaOperatorInSwitchCaseCheck.class,
      CommaOperatorUseCheck.class,
      CommentRegularExpressionCheck.class,
      CommentedCodeCheck.class,
      ComparisonWithNaNCheck.class,
      ConciseRegexCheck.class,
      ConditionalIndentationCheck.class,
      ConditionalOperatorCheck.class,
      ConfidentialInformationLoggingCheck.class,
      ConsistentReturnsCheck.class,
      ConsoleLoggingCheck.class,
      ConstructorFunctionsForSideEffectsCheck.class,
      ContentLengthCheck.class,
      ContentSecurityPolicyCheck.class,
      ContinueStatementCheck.class,
      CookieNoHttpOnlyCheck.class,
      CookiesCheck.class,
      CorsCheck.class,
      CounterUpdatedInLoopCheck.class,
      CsrfCheck.class,
      CyclomaticComplexityJavaScriptCheck.class,
      CyclomaticComplexityTypeScriptCheck.class,
      DeadStoreCheck.class,
      DebuggerStatementCheck.class,
      DeclarationInGlobalScopeCheck.class,
      DefaultParametersNotLastCheck.class,
      DeleteNonPropertyCheck.class,
      DeprecationCheck.class,
      DestructuringAssignmentSyntaxCheck.class,
      DifferentTypesComparisonCheck.class,
      DisabledAutoEscapingCheck.class,
      DisabledResourceIntegrityCheck.class,
      DisabledTimeoutCheck.class,
      DnsPrefetchingCheck.class,
      DuplicateAllBranchImplementationCheck.class,
      DuplicateBranchImplementationCheck.class,
      DuplicateConditionIfCheck.class,
      DuplicateFunctionArgumentCheck.class,
      DuplicatePropertyNameCheck.class,
      DuplicatesInCharacterClassCheck.class,
      ElseIfWithoutElseCheck.class,
      EmptyBlockCheck.class,
      EmptyCharacterClassesCheck.class,
      EmptyDestructuringPatternCheck.class,
      EmptyFunctionCheck.class,
      EmptyStatementCheck.class,
      EmptyStringRepetitionCheck.class,
      EncryptionCheck.class,
      EncryptionSecureModeCheck.class,
      EqEqEqCheck.class,
      EqualInForLoopTerminationCheck.class,
      ErrorWithoutThrowCheck.class,
      EvalCheck.class,
      ExistingGroupsCheck.class,
      ExpressionComplexityCheck.class,
      FileHeaderCheck.class,
      FileNameDiffersFromClassCheck.class,
      FilePermissionsCheck.class,
      FileUploadsCheck.class,
      FixmeTagPresenceCheck.class,
      ForHidingWhileCheck.class,
      ForInCheck.class,
      ForLoopConditionAndUpdateCheck.class,
      ForLoopIncrementSignCheck.class,
      FrameAncestorsCheck.class,
      FunctionCallArgumentsOnNewLineCheck.class,
      FunctionConstructorCheck.class,
      FunctionDeclarationsWithinBlocksCheck.class,
      FunctionDefinitionInsideLoopCheck.class,
      FunctionNameCheck.class,
      FunctionReturnTypeCheck.class,
      FutureReservedWordsCheck.class,
      GeneratorWithoutYieldCheck.class,
      GetterSetterCheck.class,
      GlobalThisCheck.class,
      GlobalsShadowingCheck.class,
      GratuitousConditionCheck.class,
      HardcodedCredentialsCheck.class,
      HashingCheck.class,
      HiddenFilesCheck.class,
      IdenticalExpressionOnBinaryOperatorCheck.class,
      IdenticalFunctionsCheck.class,
      IgnoredReturnCheck.class,
      ImmediatelyReturnedVariableCheck.class,
      ImplicitDependenciesCheck.class,
      InOperatorTypeErrorCheck.class,
      InconsistentFunctionCallCheck.class,
      IncrementDecrementInSubExpressionCheck.class,
      IndexOfCompareToPositiveNumberCheck.class,
      InsecureCookieCheck.class,
      InsecureJwtTokenCheck.class,
      InstanceofInMisuseCheck.class,
      IntrusivePermissionsCheck.class,
      InvariantReturnCheck.class,
      InvertedAssertionArgumentsCheck.class,
      IpForwardCheck.class,
      JsxKeyCheck.class,
      JsxNoBindCheck.class,
      JsxNoCommentTextnodesCheck.class,
      JsxNoConstructedContextValuesCheck.class,
      JsxNoLeakedRenderCheck.class,
      JumpStatementInFinallyCheck.class,
      LabelPlacementCheck.class,
      LabelledStatementCheck.class,
      LineLengthCheck.class,
      LinkWithTargetBlankCheck.class,
      LoopsShouldNotBeInfiniteCheck.class,
      MaxParameterCheck.class,
      MaxSwitchCasesCheck.class,
      MaxUnionSizeCheck.class,
      MisorderedParameterListCheck.class,
      MissingNewlineAtEndOfFileCheck.class,
      MissingTrailingCommaCheck.class,
      MultilineBlockCurlyBraceCheck.class,
      MultilineStringLiteralsCheck.class,
      NestedAssignmentCheck.class,
      NestedConditionalOperatorsCheck.class,
      NestedControlFlowDepthCheck.class,
      NewOperatorMisuseCheck.class,
      NoAccessorFieldMismatchCheck.class,
      NoAngularBypassSanitizationCheck.class,
      NoAnyCheck.class,
      NoArrayDeleteCheck.class,
      NoArrayIndexKeyCheck.class,
      NoAsyncPromiseExecutorCheck.class,
      NoClearTextProtocolsCheck.class,
      NoCodeAfterDoneCheck.class,
      NoControlRegexCheck.class,
      NoDuplicateImportsCheck.class,
      NoDuplicateInCompositeCheck.class,
      NoDuplicateStringCheck.class,
      NoElementOverwriteCheck.class,
      NoEmptyAfterReluctantCheck.class,
      NoEmptyAlternativesCheck.class,
      NoEmptyCollectionCheck.class,
      NoEmptyGroupCheck.class,
      NoEmptyInterfaceCheck.class,
      NoExclusiveTestsCheck.class,
      NoExtraBooleanCastCheck.class,
      NoForInArrayCheck.class,
      NoHardcodedIpCheck.class,
      NoHookSetterInBodyCheck.class,
      NoIgnoredExceptionsCheck.class,
      NoImportAssignCheck.class,
      NoInMisuseCheck.class,
      NoIncompleteAssertionsCheck.class,
      NoInferrableTypesCheck.class,
      NoInvalidAwaitCheck.class,
      NoInvertedBooleanCheckCheck.class,
      NoLossOfPrecisionCheck.class,
      NoMagicNumbersCheck.class,
      NoMimeSniffCheck.class,
      NoMisleadingArrayReverseCheck.class,
      NoMisusedNewCheck.class,
      NoMixedContentCheck.class,
      NoNestedSwitchCheck.class,
      NoNestedTemplateLiteralsCheck.class,
      NoNonNullAssertionCheck.class,
      NoOneIterationLoopCheck.class,
      NoOsCommandsFromPathCheck.class,
      NoRedundantJumpCheck.class,
      NoRedundantOptionalCheck.class,
      NoReferrerPolicyCheck.class,
      NoRegexSpacesCheck.class,
      NoReturnAwaitCheck.class,
      NoReturnTypeAnyCheck.class,
      NoSameArgumentAssertCheck.class,
      NoSparseArraysCheck.class,
      NoThisAliasCheck.class,
      NoUniqKeyCheck.class,
      NoUnnecessaryTypeAssertionCheck.class,
      NoUnsafeOptionalChainingCheck.class,
      NoUnstableNestedComponentsCheck.class,
      NoUnusedClassComponentMethodsCheck.class,
      NoUselessCatchCheck.class,
      NoUselessReactSetstateCheck.class,
      NoVueBypassSanitizationCheck.class,
      NoWeakCipherCheck.class,
      NoWeakKeysCheck.class,
      NonCaseLabelInSwitchCheck.class,
      NonEmptyCaseWithoutBreakCheck.class,
      NonExistentAssignmentOperatorCheck.class,
      NonNumberInArithmeticExpressionCheck.class,
      NonStandardImportCheck.class,
      NullDereferenceCheck.class,
      OSCommandCheck.class,
      ObjectLiteralShorthandCheck.class,
      OctalNumberCheck.class,
      OneStatementPerLineCheck.class,
      OpenCurlyBracesAtEOLCheck.class,
      ParenthesesCheck.class,
      ParseIntCallWithoutBaseCheck.class,
      ParsingErrorCheck.class,
      PostMessageCheck.class,
      PreferDefaultLastCheck.class,
      PreferForOfCheck.class,
      PreferNamespaceCheck.class,
      PreferObjectLiteralCheck.class,
      PreferPromiseShorthandCheck.class,
      PreferReadonlyCheck.class,
      PreferRegexLiteralsCheck.class,
      PreferTypeGuardCheck.class,
      PrimitiveWrappersCheck.class,
      ProcessArgvCheck.class,
      ProductionDebugCheck.class,
      PseudoRandomCheck.class,
      PubliclyWritableDirectoriesCheck.class,
      ReassignedParameterCheck.class,
      RedeclaredSymbolCheck.class,
      RedundantAssignmentCheck.class,
      ReferenceErrorCheck.class,
      RegexComplexityCheck.class,
      RegularExprCheck.class,
      RequireRenderReturnCheck.class,
      ReturnInSetterCheck.class,
      ReturnOfBooleanExpressionCheck.class,
      RulesOfHooksCheck.class,
      SameLineConditionalCheck.class,
      SelfAssignmentCheck.class,
      SemicolonCheck.class,
      SessionRegenerationCheck.class,
      ShorthandPropertiesNotGroupedCheck.class,
      SingleCharInCharacterClassesCheck.class,
      SingleCharacterAlternativeCheck.class,
      SlowRegexCheck.class,
      SocketsCheck.class,
      SonarNoInvalidRegexCheck.class,
      SonarNoMisleadingCharacterClassCheck.class,
      SqlQueriesCheck.class,
      StandardInputCheck.class,
      StatefulRegexCheck.class,
      StrictModeCheck.class,
      StrictTransportSecurityCheck.class,
      StringConcatenatedWithNonStringCheck.class,
      StringConcatenationCheck.class,
      StringLiteralsQuotesCheck.class,
      StringsComparisonCheck.class,
      SuperInvocationCheck.class,
      SwitchWithNotEnoughCaseCheck.class,
      SwitchWithoutDefaultCheck.class,
      SymbolUsedAsConstructorCheck.class,
      TabCharacterCheck.class,
      TemplateStringMisuseCheck.class,
      TestCheckExceptionCheck.class,
      ThrowLiteralCheck.class,
      TodoTagPresenceCheck.class,
      TooManyArgumentsCheck.class,
      TooManyBreakOrContinueInLoopCheck.class,
      TooManyLinesInFileCheck.class,
      TooManyLinesInFunctionCheck.class,
      TrailingCommaCheck.class,
      TrailingCommentCheck.class,
      TrailingWhitespaceCheck.class,
      TryPromiseCheck.class,
      UnchangedLetVariableCheck.class,
      UndefinedArgumentCheck.class,
      UndefinedAssignmentCheck.class,
      UnicodeAwareRegexCheck.class,
      UnnecessaryCharacterEscapesCheck.class,
      UnnecessaryTypeArgumentsCheck.class,
      UnreachableCodeCheck.class,
      UnsafeUnzipCheck.class,
      UnusedCollectionCheck.class,
      UnusedFunctionArgumentCheck.class,
      UnusedImportCheck.class,
      UnusedNamedGroupsCheck.class,
      UnusedVariableCheck.class,
      UnverifiedCertificateCheck.class,
      UnverifiedHostnameCheck.class,
      UpdatedConstVariableCheck.class,
      UseOfEmptyReturnValueCheck.class,
      UseTypeAliasCheck.class,
      UselessExpressionStatementCheck.class,
      UselessIncrementCheck.class,
      UselessIntersectionCheck.class,
      UselessStringOperationCheck.class,
      ValidTypeOfCheck.class,
      ValuesNotConvertibleToNumbersCheck.class,
      VarDeclarationCheck.class,
      VariableDeclarationAfterUsageCheck.class,
      VariableDeclarationWithoutVarCheck.class,
      VariableNameCheck.class,
      VariableShadowingCheck.class,
      VoidUseCheck.class,
      WeakSslCheck.class,
      WebSQLDatabaseCheck.class,
      WildcardImportCheck.class,
      WithStatementCheck.class,
      WrongScopeDeclarationCheck.class,
      XMLParserXXEVulnerableCheck.class,
      XPoweredByCheck.class,
      XpathCheck.class
    );
  }
}