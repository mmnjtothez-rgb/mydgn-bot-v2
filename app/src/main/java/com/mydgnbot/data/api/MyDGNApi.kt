interface MyDGNApi {

    @GET("transfers")
    suspend fun getTransfer(
        ...
    ): ApiPlayer


    @POST("status")
    suspend fun updateStatus(
        ...
    ): StatusResponse

}
