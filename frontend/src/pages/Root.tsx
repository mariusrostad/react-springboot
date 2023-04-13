import {Link} from "react-router-dom";

export default function RootPage() {
  return (
    <main>
      <h1>Root page</h1>
      <Link to={"/blog"}>Blog</Link>
    </main>
  )
}
