/*
 * Copyright (c) 2017
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package jsettlers.main.android.gameplay.presenters;

import java.util.List;

import jsettlers.common.buildings.EBuildingType;
import jsettlers.graphics.action.Action;
import jsettlers.graphics.action.ActionFireable;
import jsettlers.graphics.action.ShowConstructionMarksAction;
import jsettlers.main.android.gameplay.navigation.MenuNavigator;
import jsettlers.graphics.map.controls.original.panel.content.EBuildingsCategory;
import jsettlers.main.android.gameplay.ui.views.BuildingsCategoryView;

/**
 * Created by tompr on 22/11/2016.
 */
public class BuildingsCategoryMenu {
	private final BuildingsCategoryView view;
	private final ActionFireable actionFireable;
	private final MenuNavigator menuNavigator;
	private final EBuildingsCategory buildingsCategory;

	public BuildingsCategoryMenu(BuildingsCategoryView view, ActionFireable actionFireable, MenuNavigator menuNavigator, EBuildingsCategory buildingsCategory) {
		this.view = view;
		this.actionFireable = actionFireable;
		this.menuNavigator = menuNavigator;
		this.buildingsCategory = buildingsCategory;
	}

	public void start() {
		view.setBuildings(getBuildingTypes());
	}

	public void buildingSelected(EBuildingType buildingType) {
		Action action = new ShowConstructionMarksAction(buildingType);
		actionFireable.fireAction(action);
		menuNavigator.dismissMenu();
	}

	private List<EBuildingType> getBuildingTypes() {
		return buildingsCategory.buildingTypes;
	}
}
