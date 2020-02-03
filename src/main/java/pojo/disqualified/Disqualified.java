package pojo.disqualified;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Disqualified {
  @SerializedName("per_page")
  @Expose
  private Integer per_page;
  @SerializedName("total")
  @Expose
  private Integer total;
  @SerializedName("data")
  @Expose
  private List<Data> data;
  @SerializedName("links")
  @Expose
  private Object links;
  @SerializedName("page")
  @Expose
  private Integer page;
}