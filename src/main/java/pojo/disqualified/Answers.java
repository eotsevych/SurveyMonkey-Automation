package pojo.disqualified;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Answers{
  @SerializedName("choice_id")
  @Expose
  private Long choice_id;
}