package pojo.disqualified;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Pages{
  @SerializedName("questions")
  @Expose
  private List<Questions> questions;
  @SerializedName("id")
  @Expose
  private Integer id;
}