package pojo.disqualified;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;
@Getter
public class Questions{
  @SerializedName("answers")
  @Expose
  private List<Answers> answers;
  @SerializedName("id")
  @Expose
  private Integer id;
}