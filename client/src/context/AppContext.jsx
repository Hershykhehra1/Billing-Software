import { createContext, useEffect, useState } from "react";
import { fetchCategories } from "../Service/CategoryService";

export const AppContext = createContext(null);

export const AppContextProvider = (props) => {

    const [categories, setCategories] = useState([]);

    useEffect(() => {
        async function loadData() {
            const response = await fetchCategories();
            setCategories(response.data);
        }

        loadData()
    }, [])

    const contextValue = {
        categories,
        setCategories,
    }

    {/* for all of the children, we pass the contect value , inside the context value we can pass the data */}
    return <AppContext.Provider value={contextValue}>
            {props.children}
        </AppContext.Provider>
    
}