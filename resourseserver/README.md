###Get code from keycloak
```http request
curl --location --request GET 'localhost:8080/auth/realms/developer/protocol/openid-connect/auth?client_id=packy-client&response_type=code&scope=openid%20profile&redirect_uri=http://localhost:8083/callback&state=qwertyuiop'
```

###Get token from keycloak
```http request
curl --location --request POST 'localhost:8080/auth/realms/developer/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=authorization_code' \
--data-urlencode 'client_id=packy-client' \
--data-urlencode 'client_secret=bdffe411-41c7-4877-87a3-56323a206a57' \
--data-urlencode 'code=a088b716-1c99-4b19-8a0f-49c39327592e.a12bb70d-4079-4ce8-9b77-5584b0b79c74.e607b652-1f8b-44e7-8f3e-86b8d0bd5a08' \
--data-urlencode 'redirect_uri=http://localhost:8083/callback'
```

###API access
```http request
curl --location --request GET 'http://localhost:8081/users/status/check' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJGR0VFMk5Fak1paEdNTVFWajl3X3E3TktRN1ROcnVRbC1TcnczOTd5NktrIn0.eyJleHAiOjE2MTUwNzY2ODcsImlhdCI6MTYxNTA3NjM4NywiYXV0aF90aW1lIjoxNjE1MDc2MzQ1LCJqdGkiOiJmZTBkZGVjZS05ZDUxLTQ5OTMtYTlkMi1jNWNiZDczY2VjZmYiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC9yZWFsbXMvZGV2ZWxvcGVyIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImRhNzY0OGY2LTYyZDAtNGZhMi05OWYyLWE4N2Y1YWUyY2YwNyIsInR5cCI6IkJlYXJlciIsImF6cCI6InBhY2t5LWNsaWVudCIsInNlc3Npb25fc3RhdGUiOiJhMTJiYjcwZC00MDc5LTRjZTgtOWI3Ny01NTg0YjBiNzljNzQiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6Im9wZW5pZCBlbWFpbCBwcm9maWxlIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5hbWUiOiJwYWNreSByYW4iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJwYWNreSIsImdpdmVuX25hbWUiOiJwYWNreSIsImZhbWlseV9uYW1lIjoicmFuIiwiZW1haWwiOiJwYWNreUBwYWNreS5jb20ifQ.Q_-2NxCssyj6cBAzefkQhNNhFApLRjZGl_dnJbt9nfck5KpwPwe4y4NXuM8PfpzM-PCB3MHGwAHFkoXJ7iiAeX6JvLoZAUuXtaKVJXsTmrsZLnlsmFDLNwUJF75T2rqS-S5pxrwaNFQ8yELo6AIkJR5WnhGduK3GyNVWkQJwfO79FqseSxJf693A8o5LAZua9pBTj155gb381g6QNFOfCgDcY0oM2qFIYsrQtsPOCfK13yPa4URoMXEY44D0AA64EaZKzexZmmlIDAR7lpXHbKZxsAbfnA_qPvt0Lb2djRy6p_71ZAIZX92D_XTHYbAIpf2QW07WKR_M6RjYRpFvgQ'
```
```http request
curl --location --request DELETE 'http://localhost:8081/users/aaa' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJGR0VFMk5Fak1paEdNTVFWajl3X3E3TktRN1ROcnVRbC1TcnczOTd5NktrIn0.eyJleHAiOjE2MTUwOTc4MzAsImlhdCI6MTYxNTA5NzUzMCwiYXV0aF90aW1lIjoxNjE1MDk3NTAzLCJqdGkiOiIxNTMxZmY0Zi03Nzg3LTQ4NDgtOTY0Ny1hMGU2NTA0NzMzNDgiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC9yZWFsbXMvZGV2ZWxvcGVyIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImRhNzY0OGY2LTYyZDAtNGZhMi05OWYyLWE4N2Y1YWUyY2YwNyIsInR5cCI6IkJlYXJlciIsImF6cCI6InBhY2t5LWNsaWVudCIsInNlc3Npb25fc3RhdGUiOiI5ZDZkMDMwMC1hYWFjLTRlMmMtYWViMi01MjM4NDEzMjVmN2UiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiYmFja2VuZCIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJuYW1lIjoicGFja3kgcmFuIiwicHJlZmVycmVkX3VzZXJuYW1lIjoicGFja3kiLCJnaXZlbl9uYW1lIjoicGFja3kiLCJmYW1pbHlfbmFtZSI6InJhbiIsImVtYWlsIjoicGFja3lAcGFja3kuY29tIn0.Z5oEWbiK5IMjjRtDuODFcVNX7dzlP1CEton9WMbnkbAsSd_6kCFp9fsoJVN8BaYoG1W6sFPN4zDtj-v67c75B9CRDtTiINmeouvbuNYmQtjcRWP4PZrzIX33kfr1eetZZbSa8MrOlxw1xuQw24_B9taBxsYM2jVVWHw2hBA785Xb3XLplHYOlccoHQrQDhQC-oZEqG4MjofJcIjSwGN_BzFkSn9QPIj11gAbzwfiVxYDoL-DEvA8FJfN27XmWogQqMn6ELSUPNmMb-RmQ6Jw67mtmSXeDXPzCgc1srgNtOpkL5AcYV1j5gm3pPWdxH12ym8FmEI3hSsiALgiqxZTrA'
```
```http request
```
```http request
```
