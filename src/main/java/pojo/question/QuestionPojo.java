package pojo.question;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;
/**
 * Awesome Pojo Generator
 * */

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionPojo{
  @SerializedName("visible")
  @Expose
  private Boolean visible;
  @SerializedName("subtype")
  @Expose
  private String subtype;
  @SerializedName("sorting")
  @Expose
  private Object sorting;
  @SerializedName("answers")
  @Expose
  private Answers answers;
  @SerializedName("headings")
  @Expose
  private List<Headings> headings;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("position")
  @Expose
  private Integer position;
  @SerializedName("href")
  @Expose
  private String href;
  @SerializedName("family")
  @Expose
  private String family;
  @SerializedName("forced_ranking")
  @Expose
  private Boolean forced_ranking;
  @SerializedName("required")
  @Expose
  private Required required;
  @SerializedName("validation")
  @Expose
  private Object validation;
}