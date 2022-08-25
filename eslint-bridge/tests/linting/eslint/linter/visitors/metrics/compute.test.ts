/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2022 SonarSource SA
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

import path from 'path';
import { SourceCode } from 'eslint';
import { computeMetrics } from 'linting/eslint';
import { parseJavaScriptSourceFile } from '../../../../../tools/helpers';

describe('computeMetrics', () => {
  it('should compute metrics', () => {
    const filePath = path.join(__dirname, 'fixtures', 'compute.js');
    const sourceCode = parseJavaScriptSourceFile(filePath) as SourceCode;
    const metrics = computeMetrics(sourceCode, true, 42);
    expect(metrics).toEqual({
      classes: 1,
      commentLines: [6],
      complexity: 2,
      cognitiveComplexity: 42,
      executableLines: [8],
      functions: 1,
      ncloc: [5, 7, 8, 9, 10],
      nosonarLines: [7],
      statements: 1,
    });
  });
});