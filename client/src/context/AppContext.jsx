import { createContext, useEffect, useState } from "react";
import { fetchCategories } from "../Service/CategoryService";
import { fetchItems } from "../Service/ItemService";

export const AppContext = createContext(null);

export const AppContextProvider = (props) => {

    const [categories, setCategories] = useState([]);
    const [itemsData, setItemsData] = useState([]);
    const [auth, setAuth] = useState({
        token: null,
        role: null,
    });

    useEffect(() => {
        async function loadData() {
            const response = await fetchCategories();
            const itemResponse = await fetchItems(); 
            setCategories(response.data);
            setItemsData(itemResponse.data);
        }

        loadData()
    }, []);

    const setAuthData = (token, role) => {
        setAuth({token, role});
    }

    const contextValue = {
        categories,
        setCategories,
        auth,
        setAuthData,
        itemsData,
        setItemsData
    }

    {/* for all of the children, we pass the contect value , inside the context value we can pass the data */}
    return <AppContext.Provider value={contextValue}>
            {props.children}
        </AppContext.Provider>
    
}