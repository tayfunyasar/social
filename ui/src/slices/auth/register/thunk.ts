//Include Both Helper File with needed methods
import {getFirebaseBackend} from "../../../helpers/firebase_helper";
import {postFakeRegister, postJwtRegister,} from "../../../helpers/fakebackend_helper";

// action
import {registerUserFailed, registerUserSuccessful, resetRegisterFlagChange,} from "./reducer";

// Is user register successfull then direct plot user in redux.
export const registerUser = (user: any) => async (dispatch: any) => {
    try {
        let response;

        if (process.env.REACT_APP_DEFAULTAUTH === "firebase") {
            const fireBaseBackend: any = getFirebaseBackend();
            response = fireBaseBackend.registerUser(user.email, user.password);
            dispatch(registerUserSuccessful(response));
        } else if (process.env.REACT_APP_DEFAULTAUTH === "jwt") {
            response = postJwtRegister('/post-jwt-register', user);
            // yield put(registerUserSuccessful(response));
        } else if (process.env.REACT_APP_API_URL) {
            response = postFakeRegister(user);
            const data: any = await response;

            if (data.message === "success") {
                dispatch(registerUserSuccessful(data));
            } else {
                dispatch(registerUserFailed(data));
            }
        }
    } catch (error) {
        dispatch(registerUserFailed(error));
    }
};

export const resetRegisterFlag = () => {
    try {
        const response = resetRegisterFlagChange();
        return response;
    } catch (error) {
        return error;
    }
};

// export const apiError = () => {
//   try {
//     const response = apiErrorChange();
//     return response;
//   } catch (error) {
//     return error;
//   }
// };