import './App.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import RootPage from "./pages/Root";
import React from "react";
import BlogPage from "./pages/Blog";

function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <RootPage/>,
    },
    {
      path: "/blog",
      element: <BlogPage/>
    }
  ]);
  return (
    <RouterProvider router={router}/>
  )
}

export default App
