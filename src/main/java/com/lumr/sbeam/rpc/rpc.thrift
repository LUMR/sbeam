namespace java com.lumr.sbeam.rpc

typedef i32 int
typedef i64 long


struct RequestData{
    1:required string group
    2:required string action
    3:optional binary data
    4:optional string className
    5:optional map<string,string> param
}

struct Result{
    1:required int code
    2:optional string message
    3:optional binary data
    4:optional string className
    5:optional map<string,string> param
}




service RPCService{
    Result call(1:RequestData req);
}