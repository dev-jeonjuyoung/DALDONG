/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ssafy.daldong.exercise.presentation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.ssafy.daldong.exercise.Screens


/** Navigation for the exercise app. **/

@Composable
fun ExerciseWearApp(
    navController: NavHostController,
    startDestination: String
) {
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.StartingUp.route) {
            val viewModel = hiltViewModel<ExerciseViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            StartingUp(onAvailable = {
                navController.navigate(Screens.Home.route) {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            }, onUnavailable = {
                navController.navigate(Screens.ExerciseNotAvailable.route) {
                    popUpTo(navController.graph.id) {
                        inclusive = false
                    }
                }
            }, hasCapabilities = uiState.hasExerciseCapabilities

            )
        }

        composable(Screens.Home.route) {
            val viewModel = hiltViewModel<ExerciseViewModel>()
            val serviceState by viewModel.exerciseServiceState
            val permissions = viewModel.permissions
            val uiState by viewModel.uiState.collectAsState()
            Home(
                onStartClick = {
                    navController.navigate(Screens.ExerciseScreen.route) {
                        popUpTo(navController.graph.id) {
                            inclusive = false //이전의 프래그먼트들은 제거되지만 ExerciseScreen은 스택에 남아있음
                        }
                    }
                },
                prepareExercise = { viewModel.prepareExercise() },
                onStart = { viewModel.startExercise() },
                serviceState = serviceState,
                permissions = permissions,
                isTrackingAnotherExercise = uiState.isTrackingAnotherExercise,
            )
        }
        composable(Screens.ExerciseScreen.route) {
            val viewModel = hiltViewModel<ExerciseViewModel>()
            val serviceState by viewModel.exerciseServiceState
            ExerciseScreen(
                onPauseClick = { viewModel.pauseExercise() },
                onEndClick = { viewModel.endExercise() },
                onResumeClick = { viewModel.resumeExercise() },
                onStartClick = { viewModel.startExercise() },
                serviceState = serviceState,
                navController = navController,
            )


        }
        composable(Screens.ExerciseNotAvailable.route) {
            ExerciseNotAvailable()
        }
        composable(
            Screens.SummaryScreen.route + "/{averageHeartRate}/{totalDistance}/{totalCalories}/{elapsedTime}",
            arguments = listOf(navArgument("averageHeartRate") { type = NavType.StringType },
                navArgument("totalDistance") { type = NavType.StringType },
                navArgument("totalCalories") { type = NavType.StringType },
                navArgument("elapsedTime") { type = NavType.StringType })
        ) {
            SummaryScreen(averageHeartRate = it.arguments?.getString("averageHeartRate")!!,
                totalDistance = it.arguments?.getString("totalDistance")!!,
                totalCalories = it.arguments?.getString("totalCalories")!!,
                elapsedTime = it.arguments?.getString("elapsedTime")!!,
                onRestartClick = {
                    navController.navigate(Screens.StartingUp.route) { //여기가 startingUp이었음
                        popUpTo(navController.graph.id) {
                            inclusive = true //이전의 프래그먼트들은 제거되지만 Home도 스택에서 제거
                        }
                    }
                }
            )
        }
    }
}

@Preview()
@Composable
fun ExerciseSampleAppPreview() {
    val navController = rememberNavController()
    ExerciseWearApp(navController = navController, startDestination = Screens.Home.route)
}




