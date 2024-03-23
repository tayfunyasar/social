import { createSlice } from "@reduxjs/toolkit";
//constants
import {
  layoutTypes,
  leftSidebarTypes,
  layoutModeTypes,
  layoutWidthTypes,
  layoutPositionTypes,
  topbarThemeTypes,
  leftsidbarSizeTypes,
  leftSidebarViewTypes,
  leftSidebarImageTypes,
  preloaderTypes,
  sidebarVisibilitytypes
} from "../../Components/constants/layout";

export const initialState = {
  layoutType: layoutTypes.VERTICAL,
  leftSidebarType: leftSidebarTypes.DARK,
  layoutModeType: layoutModeTypes.LIGHTMODE,
  layoutWidthType: layoutWidthTypes.FLUID,
  layoutPositionType: layoutPositionTypes.FIXED,
  topbarThemeType: topbarThemeTypes.LIGHT,
  leftsidbarSizeType: leftsidbarSizeTypes.DEFAULT,
  leftSidebarViewType: leftSidebarViewTypes.DEFAULT,
  leftSidebarImageType: leftSidebarImageTypes.NONE,
  preloader: preloaderTypes.DISABLE,
  sidebarVisibilitytype: sidebarVisibilitytypes.SHOW
};

const LayoutSlice = createSlice({
  name: 'LayoutSlice',
  initialState,
  reducers: {
    changeLayoutAction(state: any, action : any) {
      state.layoutType = action.payload;
    },
    changeLayoutModeAction(state: any, action : any) {
      state.layoutModeType = action.payload;
    },
    changeSidebarThemeAction(state: any, action : any) {
      state.leftSidebarType = action.payload;
    },
    changeLayoutWidthAction(state: any, action : any) {
      state.layoutWidthType = action.payload;
    },
    changeLayoutPositionAction(state: any, action : any) {
      state.layoutPositionType = action.payload;
    },
    changeTopbarThemeAction(state: any, action : any) {
      state.topbarThemeType = action.payload;
    },
    changeLeftsidebarSizeTypeAction(state: any, action : any) {
      state.leftsidbarSizeType = action.payload;
    },
    changeLeftsidebarViewTypeAction(state: any, action : any) {
      state.leftSidebarViewType = action.payload;
    },
    changeSidebarImageTypeAction(state: any, action : any) {
      state.leftSidebarImageType = action.payload;
    },
    changePreLoaderAction(state: any, action : any) {
      state.preloader = action.payload;
    },
    changeSidebarVisibilityAction(state: any, action : any) {
      state.sidebarVisibilitytype = action.payload;
    }
  }
});

export const {
  changeLayoutAction,
  changeLayoutModeAction,
  changeSidebarThemeAction,
  changeLayoutWidthAction,
  changeLayoutPositionAction,
  changeTopbarThemeAction,
  changeLeftsidebarSizeTypeAction,
  changeLeftsidebarViewTypeAction,
  changeSidebarImageTypeAction,
  changePreLoaderAction,
  changeSidebarVisibilityAction
} = LayoutSlice.actions;

export default LayoutSlice.reducer;