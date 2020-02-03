package pojo.surveys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Data{
  @SerializedName("nickname")
  @Expose
  private String nickname;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("href")
  @Expose
  private String href;
  @SerializedName("title")
  @Expose
  private String title;
}