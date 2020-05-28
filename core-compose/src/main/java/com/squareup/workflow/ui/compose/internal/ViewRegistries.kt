/*
 * Copyright 2020 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.workflow.ui.compose.internal

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Modifier
import com.squareup.workflow.ui.ViewEnvironment
import com.squareup.workflow.ui.ViewFactory
import com.squareup.workflow.ui.ViewRegistry

/**
 * Renders [rendering] into the composition using this [ViewRegistry] to determine how to draw it.
 *
 * To display a nested rendering from a [Composable view binding][composedViewFactory], use
 * [ViewEnvironment.showRendering].
 *
 * @see ViewEnvironment.showRendering
 * @see ViewFactory.showRendering
 */
@Composable internal fun ViewRegistry.showRendering(
  rendering: Any,
  hints: ViewEnvironment,
  modifier: Modifier = Modifier
) {
  val renderingType = rendering::class
  val viewFactory = remember(this, renderingType) { getFactoryFor(renderingType) }
  viewFactory.showRendering(rendering, hints, modifier)
}
