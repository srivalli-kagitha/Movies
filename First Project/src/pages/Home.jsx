import { useEffect, useState } from 'react';
import './Home.css'
import { useNavigate } from 'react-router-dom';
export default function Home() {
    // Create a state to store the movies data
    const [movies, setMovies] = useState([]);
    const [page, setPage] = useState(0);
    const navigate = useNavigate()
    const getMovies = async () => {
        const myHeaders = new Headers();
        const token = localStorage.getItem("token")
        console.log(token)
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Authorization", `Bearer ${token}`);

        const requestOptions = {
            method: "GET",
            headers: myHeaders,
            redirect: "follow"
        };

        const response = await fetch(`http://localhost:9000/movies?page=${page}&size=10`, requestOptions)
        const data = await response.json()
        // update the movies state with the data received from the API
        setMovies([...movies, ...data])
    }
    const logout = () => {
        localStorage.removeItem("token");
        navigate("/login")
    }
    useEffect(() => {
        getMovies()
    }, [page])
    return <>
        <header>
            <nav>
                <h1>IMDB</h1>
                <input type="text" placeholder="Search movies..." />
                <button onClick={logout}>Logout</button>
            </nav>
        </header>
        <main>
            {/* To display movies data */}
            <div className="movies">
                {movies.map((movie) => {
                    return <div key={movie.id} className="movie">
                        <img src={movie.posterUrl} alt={movie.title} />
                        <h2>{movie.title} <span>({movie.publishedYear})</span></h2>
                        <p>{movie.description.substring(0, 30)}...</p>
                    </div>
                })}
            </div>
            
        </main >
        <footer>
            <button onClick={() => setPage(page + 1)}>Load More</button>
        </footer>
    </>

}
