/* 
https://api.upbit.com/v1/market/all
{
    "market": "KRW-BTC",
    "korean_name": "비트코인",
    "english_name": "Bitcoin"
  }
*/
// async function coinInfo () {
//     await fetch("//")
// }

// const coinInfo = async function() {
//     await
// }

const market = document.querySelector("#market");

// const coinInfo = async () => {
//   const response = await fetch("https://api.upbit.com/v1/market/all");
//   const coinData = await response.json();

//   for (const i of coinData) {
//     const p = document.createElement("p");
//     p.setAttribute("id", i.market);
//     p.innerHTML = `${i.korean_name} (${i.market}) `;
//     market.appendChild(p);
//   }
// };

// coinInfo();

const dataFetch = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  const data = await response.json();
  //   for (let i = 0; i < data.length; i++) {
  //     console.log(data[i]);
  //   }
  //   data.forEach((item) => {
  //     // startsWith : 시작하는 단어 여부, includes : 포함 여부
  //     if (item.market.includes("KRW")) {
  //       market.innerHTML += `<h2>${item.korean_name} (${item.market})</h2>`;
  //     }
  //     // market.innerHTML += `<h2>${item.korean_name} (${item.market})</h2>`;
  //     // console.log(item.market, item.market.includes("KRW"));
  //     // console.log(item.korean_name);
  //   });

  // forEach + 조건문: filter
  const krwMarkets = data.filter((item) => item.market.includes("KRW"));

  //   let markets = "";
  //   krwMarkets.forEach((item) => {
  //     markets += item.market + ",";
  //   });

  // foreach + 내가 원하는 형태로 가공하고자 할때 : map
  const markets = krwMarkets.map((item) => item.market);

  const tickerResponse = await fetch(
    "https://api.upbit.com/v1/ticker?markets=" + markets.join(",")
  );
  const ticherData = await tickerResponse.json();
  console.log(ticherData);
  krwMarkets.forEach((item) => {
    const ticker = ticherData.find((ticker) => ticker.market === item.market);
    market.innerHTML += `<h2>${item.korean_name} (${item.market})</h2>
    <p>현재가 : ${ticker.trade_price.toLocaleString()}원</p>
    <p>24시간 거래량 : ${ticker.acc_trade_volume_24h.toFixed(2)}</p>
    <p>전일대비 : ${
      ticker.change === "RISE"
        ? "상승"
        : ticker.change === "FALL"
        ? "하락"
        : "보합"
    } (${(ticker.change_rate * 100).toFixed(2)}%)</p>`;
  });
};

dataFetch();
