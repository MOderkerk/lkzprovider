DROP TABLE IF EXISTS lkz;
CREATE TABLE IF NOT EXISTS lkz(
   laendername      VARCHAR(80) NOT NULL PRIMARY KEY
  ,bev_gebiet       INT 
  ,bev_staatang     INT 
  ,bev_staat        INT 
  ,iso316612        VARCHAR(2)
  ,iso316613        VARCHAR(3)
  ,iso31661num      INT 
  ,banklkz2         VARCHAR(2)
  ,banklkznum       INT 
  ,banklkzkurz      VARCHAR(20)
  ,bankwaehrungcode VARCHAR(10)
  ,icao             VARCHAR(3)
  ,aussenhandelcode VARCHAR(2)
  ,kfzKennzeichen   VARCHAR(3)
  ,postadrfeld      VARCHAR(80)
  ,vollform         VARCHAR(80)
);