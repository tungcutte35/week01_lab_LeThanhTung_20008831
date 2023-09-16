/* eslint-disable array-callback-return */
import React, { useEffect, useRef, useState } from "react";
import axios from "axios";
// import lodash from "lodash";
// http://hn.algolia.com/api/v1/search/?query=react
const HackerNews = () => {
  const [hits, setHits] = useState([]);
  const [query, setQuery] = useState("");
  const [loading, setLoading] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");
  const handlFetchData = useRef({});
  const [url, setUrl] = useState(
    `http://hn.algolia.com/api/v1/search?query=${query}`
  );

  handlFetchData.current = async () => {
    setLoading(true);
    try {
      const response = await axios.get(url);
      setHits(response.data?.hits || []);
      setLoading(false);
    } catch (error) {
      setLoading(false);
      setErrorMessage(`The Error ${error}`);
    }
  };
  // const handlUpdateQuery = lodash.debounce((e) => {
  //   setQuery(e.target.value);
  // }, 1000);
  useEffect(() => {
    handlFetchData.current();
  }, [url]);
  return (
    <div className="bg-white mx-auto mt-5 mb-5 p-5 rounded-md shadow-md w-2/4">
      <div className="flex gap-x-5 mb-5 ">
        <input
          type="text"
          defaultValue={query}
          onChange={(e) => setQuery(e.query.value)}
          className="border border-gray-200  p-5 block w-full rounded-md transition-all focus:border-blue-400"
          placeholder="Typing your keyword..."
        />
        <button
          onClick={() =>
            setUrl(`http://hn.algolia.com/api/v1/search?query=${query}`)
          }
          className="bg-blue-400 p-5 rounded-lg text-white"
        >
          Fetching
        </button>
      </div>
      {loading && (
        <div className="loading w-8 h-8 rounded-full border-4 border-blue-400 border-r-transparent border-r-4 animate-spin mx-auto my-10"></div>
      )}
      {!loading && errorMessage && (
        <p className="text-red-500 my-5">{errorMessage}</p>
      )}
      <div className="flex flex-wrap gap-5">
        {!loading &&
          hits.length > 0 &&
          hits.map((item, index) => (
            <div key={item.title}>
              <h3 className="p-3 bg-gray-100 rounded-md">{item.title}</h3>
            </div>
          ))}
      </div>
    </div>
  );
};

export default HackerNews;
