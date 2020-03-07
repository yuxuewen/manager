package com.macro.mall.tiny.mongo;

import com.macro.mall.tiny.dto.WebLog;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface LogRecordRepository extends MongoRepository<WebLog,String>
{

 //   D:\company\installpath\mongodb\bin\mongod.exe --config "D:\company\installpath\mongodb\mongod.cfg" --install


}

