package pojo.answer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Answer {
  @SerializedName("choices")
  @Expose
  private List<Choices> choices;
}