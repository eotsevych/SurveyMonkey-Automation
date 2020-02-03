package pojo.disqualified;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Data {
  @SerializedName("metadata")
  @Expose
  private Object metadata;
  @SerializedName("response_status")
  @Expose
  private String response_status;
  @SerializedName("date_created")
  @Expose
  private String date_created;
  @SerializedName("custom_variables")
  @Expose
  private Object custom_variables;
  @SerializedName("custom_value")
  @Expose
  private String custom_value;
  @SerializedName("logic_path")
  @Expose
  private Object logic_path;
  @SerializedName("ip_address")
  @Expose
  private String ip_address;
  @SerializedName("survey_id")
  @Expose
  private Integer survey_id;
  @SerializedName("pages")
  @Expose
  private List<Pages> pages;
  @SerializedName("date_modified")
  @Expose
  private String date_modified;
  @SerializedName("collection_mode")
  @Expose
  private String collection_mode;
  @SerializedName("collector_id")
  @Expose
  private Integer collector_id;
  @SerializedName("edit_url")
  @Expose
  private String edit_url;
  @SerializedName("page_path")
  @Expose
  private List<Object> page_path;
  @SerializedName("id")
  @Expose
  private Long id;
  @SerializedName("href")
  @Expose
  private String href;
  @SerializedName("analyze_url")
  @Expose
  private String analyze_url;
  @SerializedName("total_time")
  @Expose
  private Integer total_time;
  @SerializedName("recipient_id")
  @Expose
  private String recipient_id;
}