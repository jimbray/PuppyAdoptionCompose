/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.ui.data.PetInfo

class PetViewModel : ViewModel() {

    val pets by mutableStateOf(
        listOf(
            PetInfo("0001", "Annie", R.drawable.airedale_terrier, "AIREDALE TERRIER", "45 - 70 pounds", "21 - 24 inches", "male", "Airedale Terriers are valiant and protective. They have a sociable, kind demeanor and they often aim to please. The breed can get distracted by small animals, other dogs, or food. In order for an Airedale Terrier to be happy, he needs to feel loved and appreciated. Also extremely intelligent, Airedale Terriers can be obedience trained at a very high echelon. As puppies, Airedale Terriers are carefree, fun-loving, and playful. For the most part, the breed is accepting of strangers, but they can become nervous if they feel threatened. Airedale Terriers frequently play too rough and rowdily for small children, but if they are raised and trained properly, they make excellent family pets. Without proper training, Airedales may become domineering or disobedient."),
            PetInfo("0002", "Bonnie", R.drawable.basset_hound, "BASSET HOUND", "45 – 65 pounds", "11 – 15 inches", "Female", "Basset Hounds are good-natured, loving companion dogs with a sweet disposition. They make wonderful companion dogs and family pets. They are known for their mild temperament and affection towards their master and children. Although never aggressive or vicious (they never bite), Basset Hounds may be a bit stubborn. They are also comparatively difficult to housebreak. This breed needs gentle guidance and lots of positive reinforcement, but they are very obedient with proper training. They like to perform tricks for food and they will chase after an interesting scent. Basset Hounds are very good-natured and kind, but they are not timid. They are friendly and fit into family life quite well. This breed is known for its deep, musical bark."),
            PetInfo("0003", "Caitlyn", R.drawable.canaan_dog, "CANARY DOG", "35 – 55 pounds", "19 – 24 inches", "male", "The Canary Dog needs a dominant owner and a family that is not uncomfortable in its presence. This breed is an excellent guard dog because of their intimidating physical appearance and ability to alert their owner(s) and confront intruders. With the proper owner, the Canary Dog makes a loyal, devoted companion. This breed isn’t suitable for first time dog owners. In the wrong hands, the Canary Dog can be aggressive and dangerous."),
            PetInfo("0004", "Dory", R.drawable.dalmatian, "DALMATIAN", "55 pounds", "20 – 24 inches", "Female", "The Dalmatian is full of stamina and energy. They prefer an active lifestyle, and they do not like to lie around all day without a task or job to perform. They are cheerful, playful, devoted, and sensitive. They thrive on human companionship and they generally do well with firm, consistent training. They are highly intelligent and trainable to a high level of obedience. Because of their need for affection, the Dalmatian does not make a good yard dog. They need to spend a good amount of time with their family on a daily basis. They love children, but they are often too rambunctious to play with babies or toddlers. While this breed is sometimes aggressive with strange dogs, they usually get along well with other pets. They are strong-willed and have an excellent memory. They will become depressed, bored, and destructive if they aren’t given sufficient exercise or affection."),
            PetInfo("0005", "Emilie", R.drawable.english_cocker_spaniel, "ENGLISH COCKER SPANIEL", "26 – 34 pounds", "14 – 17 inches", "male", "The English Cocker Spaniel is good-natured, cheerful, energetic, and hardy. They are even-tempered, affectionate, and loving, and they get along very well with children. They are gentle, playful, and patient, and they respectfully obey all orders they are given. While they are usually social and outgoing, some English Cocker Spaniels may be reserved around strangers. The temperament varies greatly between specimens of this breed. Many dogs of the field variety are too active to keep as household pets. This breed usually gets along well with cats and other dogs."),
            PetInfo(
                "0006", "Fell", R.drawable.french_bulldog, "FRENCH BULLDOG", "19 - 28 pounds", "12 inches", "Female",
                "The French Bulldog is a cheerful, low-maintenance companion. They are pleasant, affectionate, and sweet, and they have a propensity to be very clownish. They are alert, curious, and even-tempered. This breed usually forms a strong bond with one person. While they are generally accepting of strangers and other animals, some males of this breed may be aggressive towards other dogs. The French Bulldog needs human companionship and attention. If left ignored or unattended for long periods of time, they can become mischievous and depressed. Although somewhat willful at times, they can be trained relatively easily by a patient owner. They are not a loud or hyper breed, but they are very enthusiastic and persistent. They get along best with older, more considerate children. A fair number of French Bulldogs have a tendency to drool and slobber.\n" +
                    "\n"
            ),
            PetInfo(
                "0007", "Glass", R.drawable.german_shepherd, "GERMAN SHEPHERD", "77 - 85 pounds", "22 - 26 inhes", "male",
                "The German Shepherd has outstanding abilities as a working dog. They are fearless, eager, and alert, and they are very obedient. They are confident, serious, and possess strong learning abilities. The breed is known for its courage and loyalty. They love to be close to their family, but they are sometimes leery of strangers. Because of their strong protective instincts, the German Shepherd should be properly trained and extensively socialized to prevent over-guarding. Aggressive behavior within this breed is due to a combination of poor breeding and training. German Shepherds are almost always good with other pets, and they are excellent with children. It is important for potential owners of this breed to buy specimens from a reputable breeder.\n" +
                    "\n" +
                    "This breed needs firm training an proper socialization to avoid aggressive tendencies. By nature, they are very protective of their owners and family. They are very smart and can be easily controlled when trained by a responsible owner. They are very loyal and love interaction with their immediate family. It's a good idea to start socialization with as many people and dogs from birth. Also, this breed can be very affectionate and protective of children.\n" +
                    "\n" +
                    "The breed has a distinct personality marked by direct and fearless, but not hostile, expression, self-confidence and a certain aloofness that does not lend itself to immediate and indiscriminate friendships. The dog must be approachable, quietly standing its ground and showing confidence and willingness to meet overtures without itself making them. It is poised, but when the occasion demands, eager and alert; both fit and willing to serve in its capacity as companion, watchdog, blind leader, herding dog, or guardian, whichever the circumstances may demand. The dog must not be timid, shrinking behind its master or handler; it should not be nervous, looking about or upward with anxious expression or showing nervous reactions, such as tucking of tail, to strange sounds or sights. Lack of confidence under any surroundings is not typical of good character. Any of the above deficiencies in character which indicate shyness must be penalized as very serious faults and any dog exhibiting pronounced indications of these must be excused from the ring. It must be possible for the judge to observe the teeth and to determine that both testicles are descended. Any dog that attempts to bite the judge must be disqualified. The ideal dog is a working animal with an incorruptible character combined with body and gait suitable for the arduous work that constitutes its primary purpose"
            ),
            PetInfo("0008", "Hope", R.drawable.hairless_khala, "HAIRLESS KHALA", "15 -30 pounds", "14 - 20 inhes", "Female", "The Hairless Khala is a loving family dog which does well with children in the family as well.  However, this breed does get along with strangers, but they will not fight because they have no fur and few teeth which makes them not capable of fighting.  This breed loves to have a hairless dog companion and will do fine with all family animals.  Not much care, such as training, is needed for this breed."),
        )
    )

    var curPet: PetInfo? by mutableStateOf(null)
    var showingDetails: Boolean by mutableStateOf(false)
    var topBarTitle: String by mutableStateOf("PuppyAdoption")

    fun startDetails(pet: PetInfo) {
        curPet = pet
        showingDetails = true
    }

    fun closeDetails() {
        showingDetails = false
        topBarTitle = "PuppyAdoption"
    }
}
