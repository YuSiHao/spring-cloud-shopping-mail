authorization_code:
1. localhost:8090/mySessionLogin?username=chandler&password=123
2. http://localhost:8090/oauth/authorize?response_type=code&client_id=catalog&client_secret=catalog&redirect_uri=http://localhost:8090/getCode
3. curl -X POST -vu catalog:catalog http://localhost:8090/oauth/token -H "Accept: application/json" -d "grant_type=authorization_code&client_id=catalog&client_secret=catalog&code=1i0l4P&redirect_uri=http://localhost:8090/getCode"
4. curl -i -H "Authorization: Bearer 0de0e6c3-f3c8-40e4-acc9-a942f98162eb" http://localhost:8090/users/testSecureClient

client_credentials:
1. curl -X POST -vu order:23 http://localhost:8090/oauth/token -H "Accept: application/json" -d "grant_type=client_credentials&client_id=order&client_secret=order"

password:
1. curl -X POST -vu auth:auth http://localhost:8090/oauth/token -H "Accept: application/json" -d "username=chandler&password=123&grant_type=password&client_id=auth&client_secret=auth"

refresh_token:
1. curl -X POST -vu order:order http://localhost:8090/oauth/token -H "Accept: application/json" -d "grant_type=refresh_token&refresh_token=3a15cd70-47d7-46b5-aed2-f41d92137db7"
