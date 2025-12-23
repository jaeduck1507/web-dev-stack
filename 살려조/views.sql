-- 생성 뷰 테이블 

-- pm
-- 아이템 총 개수
CREATE OR REPLACE VIEW item_qty AS
SELECT
    item_info_id,
    COUNT(*) AS total_qty
FROM item
GROUP BY item_info_id;

CREATE OR REPLACE VIEW item_qty_rent_possible AS
SELECT
    item_info_id,
    COUNT(*) AS qty_rent_possible
FROM item
where is_id = 0
GROUP BY item_info_id;

-- crm
-- 장소 + 예약정보 가장 최신 또는 없을때 들고오기
CREATE OR REPLACE VIEW location_latest_reservation AS
SELECT
  l.*,
  rr_pick.rr_id            AS rr_id,
  rr_pick.rent_start       AS rent_start,
  rr_pick.rent_end         AS rent_end,
  rr_pick.rent_days		   AS rent_days,
  rr_pick.ad_cost		   AS ad_cost
  -- rr_pick.rental_fee       AS rr_rental_fee
FROM location AS l
LEFT JOIN (
  SELECT
    rr.*,
    ROW_NUMBER() OVER (
      PARTITION BY rr.location_id
      ORDER BY
        (rr.rent_end IS NULL) ASC,  -- NOT NULL 우선
        rr.rent_end DESC,           -- 가장 큰 날짜 우선
        rr.rent_start DESC,
        rr.rr_id DESC
    ) AS rn
  FROM rent_reservation rr
) AS rr_pick
  ON rr_pick.location_id = l.location_id
 AND rr_pick.rn = 1;