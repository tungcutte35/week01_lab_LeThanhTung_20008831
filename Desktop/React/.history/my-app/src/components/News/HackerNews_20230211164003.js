import React, { useEffect, useState } from "react";
import axios from "axios";
// http://hn.algolia.com/api/v1/search/?query=react
const HackerNews = () => {
  const [hits, setHits] = useState([]);
  const handlFetchData = async () => {
    const response = await axios.get(
      "http://hn.algolia.com/api/v1/search/?query=react"
    );
    console.log(response);
  };
  useEffect(() => {
    handlFetchData();
  }, []);
  return (
    <div>
      {hits.length > 0 &&
        // eslint-disable-next-line array-callback-return
        hits.map((item, index) => {
          <h3 key={item.title}>{item.title}</h3>;
        })}
    </div>
  );
};

export default HackerNews;
