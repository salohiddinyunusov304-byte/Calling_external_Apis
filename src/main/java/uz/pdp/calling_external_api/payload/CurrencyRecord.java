package uz.pdp.calling_external_api.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrencyRecord(
        @JsonProperty("id") int id,
        @JsonProperty("Code") String code,
        @JsonProperty("Ccy") String ccy,
        @JsonProperty("CcyNm_RU") String ccyNmRU,
        @JsonProperty("CcyNm_UZ") String ccyNmUZ,
        @JsonProperty("CcyNm_UZC") String ccyNmUZC,
        @JsonProperty("CcyNm_EN") String ccyNmEN,
        @JsonProperty("Nominal") int nominal,
        @JsonProperty("Rate") double rate,
        @JsonProperty("Diff") double diff,
        @JsonProperty("Date") String date
) {}
