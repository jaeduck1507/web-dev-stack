const apiKey = "";
const pl = "PLjAr2lwqsAFvS6U8534jELPVNu_La1Csk";
const pl2 = "CY9NrL3Szvg";
const aa = document.querySelector("#aa");

const dataShow = async () => {
  const response = await fetch(
    `https://www.googleapis.com/youtube/v3/playlistItems?part=snippet,contentDetails&playlistId=${pl}&key=${apiKey}`
  );
  const data = await response.json();

  console.log(data.items[1].contentDetails.videoId);
  // 재생목록으로 비디오 아이디 추출시 .item[index].contentDetails.videoId에 정보 담김
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
