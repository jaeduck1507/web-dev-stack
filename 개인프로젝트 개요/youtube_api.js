const apiKey = "";
const pl = "PLjAr2lwqsAFvS6U8534jELPVNu_La1Csk";
const pl2 = "CY9NrL3Szvg";
const aa = document.querySelector("#aa");

const dataShow = async () => {
  const response = await fetch(
    `https://www.googleapis.com/youtube/v3/playlistItems?part=snippet,contentDetails&playlistId=${pl}&key=${apiKey}`
  );
  const data = await response.json();
  console.log(data);
};

const dataShow2 = async () => {
  const response = await fetch(
    `https://www.googleapis.com/youtube/v3/videos?part=contentDetails,snippet,status,localizations&id=${pl2}&key=${apiKey}`
  );
  const data = await response.json();
  console.log(data);
};
dataShow();
dataShow2();
